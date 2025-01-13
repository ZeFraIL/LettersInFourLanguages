package zeev.fraiman.lettersinfourlanguages;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private char randomLetter;
    private final char[] englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    private final char[] georgianAlphabet = "აბგდევზთიკლმნოპჟრსტუფქღყშჩცძწჭხჯჰ".toCharArray();
    private final char[] amharicAlphabet = "ሀሁሂሃሄህሆሐሑሒሓሔሕሖመሙሚማሜምሞሠሡሢሣሤሥሦረሩሪራር".toCharArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rgLanguages = findViewById(R.id.rgLanguages);
        CheckBox cbShowNeighbors = findViewById(R.id.cbShowNeighbors);
        CheckBox cbShowAlphabetPosition = findViewById(R.id.cbShowAlphabetPosition);
        CheckBox cbConvertCase = findViewById(R.id.cbConvertCase);
        Button btnAnalyze = findViewById(R.id.btnAnalyze);
        TextView tvResult = findViewById(R.id.tvResult);

        btnAnalyze.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder();

            int selectedId = rgLanguages.getCheckedRadioButtonId();
            char[] alphabet = null;

            if (selectedId == R.id.rbEnglish) {
                alphabet = englishAlphabet;
                randomLetter = generateRandomLetter(alphabet);
            } else if (selectedId == R.id.rbRussian) {
                alphabet = russianAlphabet;
                randomLetter = generateRandomLetter(alphabet);
            } else if (selectedId == R.id.rbGeorgian) {
                alphabet = georgianAlphabet;
                randomLetter = generateRandomLetter(alphabet);
            } else if (selectedId == R.id.rbAmharic) {
                alphabet = amharicAlphabet;
                randomLetter = generateRandomLetter(alphabet);
            }

            if (alphabet == null) {
                Toast.makeText(this, "Select language!", Toast.LENGTH_SHORT).show();
                return;
            }

            result.append("Random letter: ").append(randomLetter).append("\n");

            if (cbShowNeighbors.isChecked()) {
                result.append("Neighboring letters: ")
                        .append(getNeighbor(randomLetter, alphabet, -1)).append(", ")
                        .append(getNeighbor(randomLetter, alphabet, 1)).append("\n");
            }

            if (cbShowAlphabetPosition.isChecked()) {
                result.append("Serial number: ")
                        .append(getAlphabetPosition(randomLetter, alphabet)).append("\n");
            }

            if (cbConvertCase.isChecked()) {
                char converted = Character.isUpperCase(randomLetter)
                        ? Character.toLowerCase(randomLetter)
                        : Character.toUpperCase(randomLetter);
                result.append("Transformed register: ").append(converted).append("\n");
            }

            tvResult.setText(result.toString());
        });
    }

    private char generateRandomLetter(char[] alphabet) {
        Random random = new Random();
        return alphabet[random.nextInt(alphabet.length)];
    }

    private char getNeighbor(char letter, char[] alphabet, int offset) {
        int index = getAlphabetPosition(letter, alphabet) - 1 + offset;
        if (index < 0 || index >= alphabet.length) {
            return '-';
        }
        return alphabet[index];
    }

    private int getAlphabetPosition(char letter, char[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter) {
                return i + 1;
            }
        }
        return -1;
    }
}
