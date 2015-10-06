import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

// SkyInvadersActivity is the entry point to the game.
// It will handle the lifecycle of the game by calling
// methods of skyInvadersView when prompted to so by the OS.
public class SkyInvadersActivity extends Activity {

    // skyInvadersView will be the view of the game
    // It will also hold the logic of the game
    // and respond to screen touches as well
    SkyInvadersView skyInvadersView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();
        // Load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);

        // Initialize gameView and set it as the view
        skyInvadersView = new SkyInvadersView(this, size.x, size.y);
        setContentView(skyInvadersView);

    }

    // This method executes when the player starts the game
    @Override
    protected void onResume() {
        super.onResume();

        // Tell the gameView resume method to execute
        skyInvadersView.resume();
    }

    // This method executes when the player quits the game
    @Override
    protected void onPause() {
        super.onPause();

        // Tell the gameView pause method to execute
        skyInvadersView.pause();
    }
}