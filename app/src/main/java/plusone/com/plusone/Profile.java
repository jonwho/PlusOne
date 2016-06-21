package plusone.com.plusone;

import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by Picknick on 6/20/2016.
 */
public class Profile {
    private ProfilePictureView profilePictureView;
    private String firstName;
    private String lastName;

    public Profile(ProfilePictureView profilePictureView, String firstName, String lastName)
    {
        this.profilePictureView = profilePictureView;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
