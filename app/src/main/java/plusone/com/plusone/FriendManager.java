package plusone.com.plusone;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Picknick on 6/22/2016.
 */
public class FriendManager {
    public class Friend {
        public Image profileImage;
        public String firstName;
        public String lastName;
        public String phoneNumber;
        public int likes;

        public Friend(Image profileImage, String firstName, String lastName, String phoneNumber, int likes)
        {
            this.profileImage = profileImage;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.likes  = likes;
        }
    }

    public static FriendManager friendManager = new FriendManager();
    public ArrayList<Friend> friendList;

    private FriendManager()
    {
        friendList = new ArrayList<Friend>();
        friendList.add(new Friend(null, "Nicky", "Huynh", "626-297-9957", 50));
        friendList.add(new Friend(null, "Nicky", "Huynh", "626-297-9957", 50));
        friendList.add(new Friend(null, "Nicky", "Huynh", "626-297-9957", 50));
        friendList.add(new Friend(null, "Nicky", "Huynh", "626-297-9957", 50));
    }
}
