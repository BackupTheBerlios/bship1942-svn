/**
 * @author Adrian Greiler, Marcel Ryser
 * 
 * PROJECT: Battleship 1942
 *
 * Changelog:
 * 
 * 24.08.2004	MR		Erstellung
 * 
 */
package ch.bship.multimedia;
import java.io.*;
import javax.sound.sampled.*;
import java.net.URL;

/**
 * Class to help playing the sound file
 *
 * The most code is copied from an example
 * -> http://www6.software.ibm.com/devtools/news0101/art22.htm#list1
 */
public class AudioPlayer {
    /** Plays audio from the given file name. */
    public static void playAudioFile(URL file) {
        try {
            // Create a stream from the file.
            // Throws IOException or// UnsupportedAudioFileException
            AudioInputStream audioInputStream = 
                AudioSystem.getAudioInputStream(
                    file);
            playAudioStream( audioInputStream );
        } catch ( Exception e ) {
            System.out.println( "Problem with file " + file + ":" );
            e.printStackTrace();
        }
    } // playAudioFile

    /** Plays audio from the given audio input stream. */
    public static void playAudioStream( AudioInputStream audioInputStream ) {
        // Audio format provides information like sample
        // rate, size, channels.
        AudioFormat audioFormat =
            audioInputStream.getFormat();
        System.out.println("AudioPlayer.playAudioStream audio format: "
            + audioFormat );

        // Open a data line to play our type of sampled
        // audio. Use SourceDataLine for play and
        // TargetDataLine for record.
        DataLine.Info info = new DataLine.Info(
            SourceDataLine.class, audioFormat );
        if ( !AudioSystem.isLineSupported( info ) ) {
            System.out.println("AudioPlayer.playAudioStream does not "
                + " handle this type of audio." );
            return;
        }

        try {
            // Create a SourceDataLine for play back
            // (throws LineUnavailableException).  
            SourceDataLine dataLine = (SourceDataLine)
                AudioSystem.getLine( info );

            // The line acquires system resources (throws
            // LineAvailableException).
            dataLine.open( audioFormat );

            // Allows the line to move data in and out to
            // a port.
            dataLine.start();

            // Create a buffer for moving data from the
            // audio stream to the line.   
            int bufferSize =
                (int) audioFormat.getSampleRate() *
                audioFormat.getFrameSize();
            byte [] buffer = new byte[ bufferSize ];

            // Move the data until done or there is an
            // error.

            try {
                int bytesRead = 0;
                while ( bytesRead >= 0 ) {
                    bytesRead = audioInputStream.read(
                        buffer, 0, buffer.length );
                    if ( bytesRead >= 0 ) 
                        dataLine.write( buffer, 0, bytesRead );
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            }

            // Continues data line I/O until its buffer is drained.
            dataLine.drain();

            // Closes the data line, freeing any resources such
            // as the audio device.
            dataLine.close();
			System.out.println("Audio Player executed successfully");
        } catch ( LineUnavailableException e ) {
            e.printStackTrace();
        }
    } // playAudioStream
}
