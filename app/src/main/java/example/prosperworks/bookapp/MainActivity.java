package example.prosperworks.bookapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Book> books = new ArrayList<Book>();
        for (List<String> list : BookProvider.getBooks()) {
            if (list == null) continue;
            books.add(new Book(list.get(0),list.get(1),list.get(2),list.get(3)));
        }
        mAdapter = new MyAdapter(books);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Object object, int pos) {
                Book b = (Book)object;
                Toast.makeText(getApplicationContext(), b.getTitle(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("book", b);
                i.putExtra("pos", pos);
                startActivityForResult(i,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        Bundle b = data.getExtras();
        boolean update = b.getBoolean("update");
        if (update) {
            Book book = (Book)b.getSerializable("book");
            mAdapter.remove(b.getInt("pos"));
            mAdapter.add(b.getInt("pos"),book);
        }

    }
}
