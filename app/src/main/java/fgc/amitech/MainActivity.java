package fgc.amitech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ViewHolder viewHolder;
List<event> eventList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
RecyclerView rv=(RecyclerView)findViewById(R.id.mainRecycle);
rv.setHasFixedSize(true);
layoutManager=new LinearLayoutManager(this);
rv.setLayoutManager(layoutManager);
//ContentAdapter adapter=new ContentAdapter(rv.getContext(),eventList);

    }}


    /*private class ContentAdapter extends RecyclerView.Adapter<ViewHolder>{
        @Override
        public ContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class ViewHolder {
    }:
}*/
