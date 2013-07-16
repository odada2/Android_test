
package com.example.myasynctask;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<String, Long, String> {

    private TextView mTextView;

    public MyAsyncTask(TextView view) {

        mTextView = view;
    }

    @Override
    protected void onPreExecute() {

        mTextView.setText("Started!!!");
    }

    @Override
    protected String doInBackground(String... params) {

         int deValue = 0; //First value in Array
         int[] myIntArray = new int[20]; //Array of 20 elements
         
               

        try {
        	 //Calculating the first value
	          
	         myIntArray[0] = 0; //First element
	         myIntArray[1] = 1; //Second element
             deValue = myIntArray[1];
	         
	         
	        Thread.sleep(2000);

	         for(int i = 2; i<20; i++)
	         {
	        	 //Calculate Fabonacci element
	        	 myIntArray[i]=  myIntArray[i-1] + myIntArray[i-2]; 
	        	 deValue = myIntArray[i];
	        	 Long valuef = (long) deValue; //Convert to long
	        	 publishProgress(valuef);
	        	 
	        	Thread.sleep(5000); // View delay wait time
	        	 
	        	if (isCancelled()) //Check for cancel call
     			break;
	        	 
	         }
	        	 
           	

        } catch (InterruptedException e) {
            Toast.makeText(mTextView.getContext(), "Smth wrong! Please check!", Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }

        return "Done!"; //Finished
    }

    @Override
    protected void onPostExecute(String result)
    {

        mTextView.setText(result);

    }

    
    protected void onProgressUpdate(Long... values) 
    {
       
        String value = String.valueOf(values[0]);
        mTextView.setText(value);

    }

}
