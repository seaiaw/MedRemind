package com.medremind.sg;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Uri fileUri;
	private static final int CAPTURE_IMAGE = 100;
	private Button cameraButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        cameraButton = (Button) findViewById(R.id.camera_button);
        
        cameraButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		 	Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        	        
//        	        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
//    	        	cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        	        
        	        startActivityForResult(cameraIntent, CAPTURE_IMAGE);
        	}
        });
        
       
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == CAPTURE_IMAGE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Image saved to:\n" + data.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * 
     */
    private void dispatchCameraIntent(int actionCode){
    	Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	startActivityForResult(cameraIntent, actionCode);
    }
    
    /**
     * 
     */
    public static boolean isIntentAvailable(Context context, String action){
    	final PackageManager packageManager = context.getPackageManager();
    	final Intent intent  = new Intent(action);
    	List<ResolveInfo> list
    		= packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
    	
    	return list.size() > 0;
    }
    
}
