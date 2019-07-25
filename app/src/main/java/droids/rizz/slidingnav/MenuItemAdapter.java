package droids.rizz.slidingnav;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import droids.rizz.slidingnav.databinding.MenuItemsBinding;

public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    MenuItemsBinding itemsBinding;

    Context context;
    List<Menu> menuList;

    public MenuItemAdapter(Context context, List<Menu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        itemsBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.menu_items, viewGroup, false);
        return new MenuItemViewHolder(itemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MenuItemViewHolder) {
            MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) viewHolder;
            menuItemViewHolder.bindData(i);
        }
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class MenuItemViewHolder extends RecyclerView.ViewHolder {
        MenuItemsBinding itemsBinding;

        MenuItemViewHolder(MenuItemsBinding itemsBinding) {
            super(itemsBinding.getRoot());
            this.itemsBinding = itemsBinding;
        }

        void bindData(int pos) {
            itemsBinding.itemName.setText(menuList.get(pos).Name);
            itemsBinding.itemIcon.setImageResource(menuList.get(pos).icon);

            itemsBinding.getRoot().setOnClickListener(v -> {
                Toast.makeText(context, menuList.get(pos).Name + "Clicked", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
