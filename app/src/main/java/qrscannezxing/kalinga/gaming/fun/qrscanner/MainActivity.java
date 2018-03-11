package qrscannezxing.kalinga.gaming.fun.qrscanner;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {
    private TextView formatTxt, contentTxt;
    private ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        progressBar=new ProgressDialog(this);
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }
    public void scanQR(View view){
        // Assume thisActivity is the current activity
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA);
        if(permissionCheck==0) {
            IntentIntegrator integrator = new IntentIntegrator(this);
            //Instructing that it detects only QR Barcodes
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
            //integrator.setPrompt(String.valueOf(R.string.txt_scan_qr_code));
            integrator.setPrompt(getString(R.string.txt_scan_qr_code));
            integrator.setResultDisplayDuration(0);
            integrator.setScanningRectangle(900,900);
            //integrator.setCaptureLayout();

            integrator.setCameraId(0);  // Use a specific camera of the device
            integrator.initiateScan();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"No scan data received!"+permissionCheck, Toast.LENGTH_SHORT).show();

        }

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        String passCode=null;
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            //we have a result
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();

            // display it on screen
           // formatTxt.setText("FORMAT: " + scanFormat);
            if(scanContent==null)
            {
                passCode="No QR code detected.";
            }
            else {
                passCode = "PASSCODE: " + scanContent;
            }
            contentTxt.setText(passCode);
            //Loading progress bar
            /*progressBar.setMessage("Congratulations!!You cracked the code...Loading Quiz..");
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressBar.setIndeterminate(true);
            progressBar.setProgress(0);*/
         //   progressBar.show();

          /*  final int totalProgressTime = 100;
            final Thread t = new Thread() {
                @Override
                public void run() {
                    int jumpTime = 0;

                    while(jumpTime < totalProgressTime) {
                        try {
                            sleep(200);
                            jumpTime += 5;
                            progressBar.setProgress(jumpTime);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.start();*/
            //TODO:Later do in onPostExecute() when JSON parsing has been done and questions are loaded

            //progressBar.dismiss();
        }

        else{
            Toast toast = Toast.makeText(getApplicationContext(),"No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    protected void onPause() {
    super.onPause();

    }
}
