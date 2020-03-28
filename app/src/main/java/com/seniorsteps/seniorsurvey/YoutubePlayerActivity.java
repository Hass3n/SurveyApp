package com.seniorsteps.seniorsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.seniorsteps.seniorsurvey.API.Responses.EntitiesResponse.Course;

public class YoutubePlayerActivity extends
        YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static Course course;
    final String key="AIzaSyAEoQpgv9ZrJdwg2YukqwWVIHAh6yWhwIQ";
    YouTubePlayerView youTubePlayerView;
    Button survey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);
       youTubePlayerView=(YouTubePlayerView)
               findViewById(R.id.youtube_view);
       survey = findViewById(R.id.survey);
       youTubePlayerView.initialize(key
       ,this);

       survey.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(YoutubePlayerActivity.this,AddVisitor.class));
           }
       });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        final YouTubePlayer youTubePlayer, boolean wasRestored) {

        if(!wasRestored){
            youTubePlayer.cueVideo(course.getYoutubeUrl());
        }
        youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {
                youTubePlayer.play();

            }

            @Override
            public void onAdStarted() {

            }

            @Override
            public void onVideoStarted() {

            }

            @Override
            public void onVideoEnded() {

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        });

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "error initializing youtube player", Toast.LENGTH_SHORT).show();
    }
}
