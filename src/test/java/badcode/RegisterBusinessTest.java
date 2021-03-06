package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RegisterBusinessTest {
    //pass
    @Test
    @DisplayName("test register success")
    public void testRegisterSuccess() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        speaker.setLastName("krub");
        speaker.setEmail("mooham.krub@live.com");
        int actual = registerBusiness.register(new MockSpeakerRepository(), speaker);
        assertEquals(1, actual);
    }

    //fail
    @Test
    @DisplayName("test register with out speaker first name")
    public void testRegisterWithoutSpeakerFirstName() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, new Speaker())
        );
        assertEquals(thrown.getMessage(), "First name is required.");
    }

    @Test
    @DisplayName("test register with out speaker lastname")
    public void testRegisterWithoutSpeakerLastname() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Last name is required.");
    }

    @Test
    @DisplayName("test register with out speaker email")
    public void testRegisterWithoutSpeakerEmail() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        speaker.setLastName("krub");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Email is required.");
    }

    @Test
    @DisplayName("test register empty speaker first name")
    public void testRegisterWithEmptySpeakerFirstName() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("");
        speaker.setLastName("krub");
        speaker.setEmail("mooham.krub@oo-course.com");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "First name is required.");
    }

    @Test
    @DisplayName("test register empty speaker lastname")
    public void testRegisterWithEmptySpeakerLastname() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        speaker.setLastName("");
        speaker.setEmail("mooham.krub@oo-course.com");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Last name is required.");
    }

    @Test
    @DisplayName("test register empty speaker email")
    public void testRegisterWithEmptySpeakerEmail() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        speaker.setLastName("krub");
        speaker.setEmail("");
        ArgumentNullException thrown = assertThrows(
                ArgumentNullException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Email is required.");
    }

    @Test
    @DisplayName("test register invalid speaker email domain")
    public void testRegisterWithSpeakerInvalidEmailDomain() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        speaker.setLastName("krub");
        speaker.setEmail("mooham.krub@oo-course.com");
        SpeakerDoesntMeetRequirementsException thrown = assertThrows(
                SpeakerDoesntMeetRequirementsException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Speaker doesn't meet our standard rules.");
    }

    @Test
    @DisplayName("test register invalid speaker email domain format.")
    public void testRegisterWithSpeakerInvalidEmailDomainFormat() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        speaker.setLastName("krub");
        speaker.setEmail("mooham.krub");
        DomainEmailInvalidException thrown = assertThrows(
                DomainEmailInvalidException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertNull(thrown.getMessage());
    }

    @Test
    @DisplayName("test register Can't save a speaker.")
    public void testRegisterWithCantSaveSpeaker() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("mooham");
        speaker.setLastName("krub");
        speaker.setEmail("mooham.krub@live.com");
        SaveSpeakerException thrown = assertThrows(
                SaveSpeakerException.class,
                () -> registerBusiness.register(null, speaker)
        );
        assertEquals(thrown.getMessage(), "Can't save a speaker.");
    }


}