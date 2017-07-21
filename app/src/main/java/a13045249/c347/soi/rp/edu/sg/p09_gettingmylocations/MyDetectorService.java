package a13045249.c347.soi.rp.edu.sg.p09_gettingmylocations;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class MyDetectorService extends Service implements  GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
  boolean started;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mlocationRequest;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Service", "Created");

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(started == false){
            started = true;
            Log.d("Service", "Started");
            mGoogleApiClient.connect();

        }else{
            Toast.makeText(MyDetectorService.this, "Service is running", Toast.LENGTH_SHORT).show();
            Log.d("Service", "Still running");
        }
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("Service", "Exited");
        super.onDestroy();
    }





}


