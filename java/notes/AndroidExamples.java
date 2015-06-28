// Small Android examples

// send sms
// Windows command prompt: pkgmgr /iu:”TelnetClient”.
// telnet localhost 5554
// sms send 5554 textmessage
/* <EditText
        android:id="@+id/phoneNumber"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="ex: 1234567890"
        android:inputType="phone" />
    <EditText
        android:id="@+id/smsBody"
        android:layout_width="fill_parent"
        android:layout_height="80dp"
        android:layout_marginBottom="30dp"
        android:hint="Write your sms here...." />
    <Button
        android:id="@+id/smsManager"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="Send the sms by SmsManager" />
*/

public class MainActivity extends Activity {

	phoneNumber = (EditText) findViewById(R.id.phoneNumber);

	smsManagerBtn = (Button) findViewById(R.id.smsManager);

String uri = "tel:"+number.getText().toString();

Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
startActivity(callIntent);

}