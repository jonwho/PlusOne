package plusone.com.plusone;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.Image;
import android.provider.ContactsContract;
import android.widget.Toast;

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

    private ContentResolver cr;
    public static FriendManager friendManager = new FriendManager();
    public ArrayList<Friend> friendList;

    public void initiateCR(ContentResolver cr)
    {
        this.cr = cr;
    }

    public void initializeDataSet()
    {
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        friendList.add(new Friend(null, name, "", phoneNo, 50));
                    }
                    pCur.close();
                }
            }
        }
    }

    private FriendManager()
    {
        friendList = new ArrayList<Friend>();
    }
}
