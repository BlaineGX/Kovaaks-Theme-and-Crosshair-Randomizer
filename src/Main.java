import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// These imports are added to Main because we'll need them for file and path handling
// when accessing Kovaaks folders or assets directly from the main logic. 
// They let us use Files.read, Files.list, Paths.get, etc. in main without cluttering
// later code with fully qualified names and make expanding main's functionality (such
// as reading theme/crosshair files) easier and clearer. (-Cursor, Written notes.)



public class Main {

private static Path findKovaaksRoot() {
    // We will scan common Steam paths on drives C: to Z:
    for (char drive = 'C'; drive <= 'Z'; drive++) {
        Path candidate1 = Paths.get(
                drive + ":\\",
                "Program Files (x86)",
                "Steam",
                "steamapps",
                "common",
                "FPSAimTrainer",
                "FPSAimTrainer"
        );

        Path candidate2 = Paths.get(
                drive + ":\\",
                "Program Files",
                "Steam",
                "steamapps",
                "common",
                "FPSAimTrainer",
                "FPSAimTrainer"
        );

        Path candidate3 = Paths.get(
                drive + ":\\",
                "Steam",
                "steamapps",
                "common",
                "FPSAimTrainer",
                "FPSAimTrainer"
        );

        Path candidate4 = Paths.get(
                drive + ":\\",
                "SteamLibrary",
                "steamapps",
                "common",
                "FPSAimTrainer",
                "FPSAimTrainer"
        );

        // Check each candidate. Files.isDirectory(...) means:
        // “does this path exist AND is it a folder?”
        if (Files.isDirectory(candidate1)) return candidate1;
        if (Files.isDirectory(candidate2)) return candidate2;
        if (Files.isDirectory(candidate3)) return candidate3;
        if (Files.isDirectory(candidate4)) return candidate4;
    }

    // If we checked everything and found nothing:
    return null;
}



public static void main(String[] args) {
    // Deliverable:
    //  Kovaaks, is a name of a Aim Training Software that is used by many pros 
    // and semi-professionals to train their aim to get the mechanical advantage.
    // This program randomly selects:
    //  1. a theme and 2. a crosshair inside of the Kovaaks Steam folder.
    // The Program will show a popup with the theme name and the crosshair image/name.
    
    // Purpose:
    //  To give the user a random theme and crosshair to use in Kovaaks. 
    // It lets the user if they want to experiment with different themes and crosshairs.
    // With in my opinion, this is a good way to help train to give the user different themes to change the environment,
    // and different crosshair to change the way they hold their angles, flick, track, etc, to let them adapt to multiple 
    // different styles and techniques with the crosshair and eye training with seeing enemies and backgrounds in different colors.

    System.out.println("Saved kovaaks path: " + Config.getKovaaksPath());



    }
}