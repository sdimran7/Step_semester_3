
import java.util.Scanner;
import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int songCount;

    Playlist(int capacity) {
        songs = new String[Math.max(0, capacity)];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
            System.out.println("Song added successfully");
        } else {
            System.out.println("Playlist is full");
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter playlist capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        if (capacity < 0) {
            System.out.println("Invalid capacity");
            sc.close();
            return;
        }

        Playlist p = new Playlist(capacity);

        System.out.print("Enter number of songs to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n < 0) {
            System.out.println("Invalid number of songs");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song title: ");
            p.addSong(sc.nextLine());
        }

        System.out.println("Songs: " + Arrays.toString(p.getSongs()));
        System.out.println("Total songs: " + p.getSongCount());

        sc.close();
    }
}
