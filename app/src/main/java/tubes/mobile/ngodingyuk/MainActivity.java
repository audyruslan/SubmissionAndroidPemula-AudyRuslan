package tubes.mobile.ngodingyuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import tubes.mobile.ngodingyuk.adapter.ListBahasaAdapter;
import tubes.mobile.ngodingyuk.adapter.OnItemClickCallback;

public class MainActivity extends AppCompatActivity {
    private RecyclerView r_bahasa;
    private ArrayList<Bahasa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_bahasa = findViewById(R.id.r_bahasa);
        r_bahasa.setHasFixedSize(true);

        list.addAll(DataBahasa.getListData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        r_bahasa.setLayoutManager(new LinearLayoutManager(this));
        ListBahasaAdapter listBahasaAdapter = new ListBahasaAdapter(list);
        r_bahasa.setAdapter(listBahasaAdapter);

        listBahasaAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Bahasa bahasa) {
                Intent moveIntent1 = new Intent(MainActivity.this, DetailBahasa.class);
                moveIntent1.putExtra(DetailBahasa.ITEM_EXTRA, bahasa);
                startActivity(moveIntent1);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.kontak_id) {
            Intent moveIntent = new Intent(MainActivity.this, ActivityTentang.class);
            startActivity(moveIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
