package com.preetham.libshare.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import com.preetham.libshare.R;
import com.preetham.libshare.fragments.FragmentSwitcher;
import com.preetham.libshare.fragments.library.adapters.SongAdapter;
import com.preetham.libshare.fragments.player.PlayerFragment;
import com.preetham.libshare.fragments.library.SongsFragment;
import com.preetham.libshare.music.Song;

import static com.preetham.libshare.Global.playQueue;

public class PlayerActivity extends AppCompatActivity {

    public static final String EXTRA_PLAY_QUEUE = "play_queue";
    public static final String EXTRA_CHANGE_TRACK = "change_track";
    private static final String PLAYER_FRAGMENT_TAG = "player_fragment";
    private static final String SONGS_FRAGMENT_TAG = "songs_fragment";
    private FragmentSwitcher playerFragmentSwitcher;
    private PlayerFragment playerFragment;

    public interface Navigator {
        void showQueue();
        void returnToPlayer();
        void returnToPlayer(int changeTrack);
    }

    Navigator playerNavigator = new Navigator() {
        @Override
        public void showQueue() {
            SongsFragment songsFragment = SongsFragment.newInstance(playQueue.getQueue(),
                    new SongAdapter.SongQueueClickListener() {
                        @Override
                        public void onSongClicked(ArrayList<Song> songList, int position) {
                            returnToPlayer(position);
                        }
                    });

            playerFragmentSwitcher.switchTo(songsFragment, SONGS_FRAGMENT_TAG);
        }

        @Override
        public void returnToPlayer() {
            playerFragmentSwitcher.switchTo(playerFragment, PLAYER_FRAGMENT_TAG, true);
        }

        @Override
        public void returnToPlayer(int changeTrack) {
            getIntent().putExtra(EXTRA_CHANGE_TRACK, changeTrack);
            returnToPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playerFragmentSwitcher = new FragmentSwitcher(getSupportFragmentManager(),
                R.id.fragment_player_main_container);
        playerFragment = PlayerFragment.newInstance(playerNavigator);
        playerFragmentSwitcher.switchTo(playerFragment, PLAYER_FRAGMENT_TAG);
    }

    @Override
    public void onBackPressed() {
        if(playerFragmentSwitcher.getCurrentFragment() == playerFragment)
            super.onBackPressed();
        else {
            playerNavigator.returnToPlayer();
        }
    }
}
