package droids.rizz.slidingnav;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.List;

import droids.rizz.slidingnav.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        setSupportActionBar(mainBinding.toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, BlankFragment.newInstance(null, null)).commit();

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(mainBinding.toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_layout)
                .inject();


        setUp();
    }

    private void setUp() {
        slidingRootNav.getLayout().findViewById(R.id.text).setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
        });

        RecyclerView recyclerView = slidingRootNav.getLayout().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MenuItemAdapter(this, getMenuItem()));
    }

    private List<Menu> getMenuItem() {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu(R.drawable.ic_home, "Home"));
        list.add(new Menu(R.drawable.ic_home, "Cart"));
        list.add(new Menu(R.drawable.ic_home, "Account"));
        list.add(new Menu(R.drawable.ic_home, "Search"));
        return list;
    }

}
