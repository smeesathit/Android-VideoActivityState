package th.ac.snru.videoactivitystate;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaController mController;
    int currentPosition;
private VideoView videoView;

//private MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playVideo();
    }

    public void playVideo(){
        videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() +
                "/" + R.raw.pre ;

        videoView.setVideoPath(path);

         mController = new MediaController(this);
        videoView.setMediaController(mController);
        mController.show();
        videoView.start();


    }

    @Override
    protected void onResume() {
        super.onResume();
        //videoView.resume();
        videoView.seekTo(currentPosition);
        videoView.start();
        //videoView.resume();

    }

    @Override
    protected void onPause() {
        super.onPause();

        videoView.pause();
        currentPosition = videoView.getCurrentPosition();

    }
}
