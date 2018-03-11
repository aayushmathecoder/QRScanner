package qrscannezxing.kalinga.gaming.fun.qrscanner;

/**
 * Created by Aayushma on 2/14/2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public ImageAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item("Level 1",       R.drawable.campus));
        mItems.add(new Item("Level 2",   R.drawable.campusatnight));
        mItems.add(new Item("Level 3", R.drawable.campusbeauty));
        mItems.add(new Item("Level 4",      R.drawable.atrium));
        mItems.add(new Item("Level 5",     R.drawable.beauty));
        mItems.add(new Item("Level 6",      R.drawable.atrium));
        mItems.add(new Item("Level 7",       R.drawable.campus));
        mItems.add(new Item("Level 8",   R.drawable.campusatnight));
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}


