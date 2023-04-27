package eu.home.jv.jokes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Создаем массив разделов:
    private String titles[] = {
            "      Начало !!!",
            "01. Чnо такое штаны?",
            "02. Как забивать гвозди.",
            "03. Пользование уборными артиллерийского полка.",
            "04. Как сажать горох и ухаживать за ним.",
            "05. Пустить шептуна или как тихо пукнуть?",
            "06. Почему люди писяют в море?",
            "07. История о вкусном квасе.",
            "08. Продолжение следует ...",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Получим идентификатор ListView
        ListView listView = findViewById(R.id.listView);
//устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);
//Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", position);
//запускаем вторую  активность
                startActivity(intent);
            }
        });
    }
}