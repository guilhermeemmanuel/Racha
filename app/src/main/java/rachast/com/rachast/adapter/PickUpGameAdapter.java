package rachast.com.rachast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import rachast.com.rachast.R;
import rachast.com.rachast.model.PickUpGame;

/**
 * Created by ATIVE BOOK on 05/02/2016.
 */
public class PickUpGameAdapter extends BaseAdapter{


    Context context;
    private List<PickUpGame> gameList;
    private static LayoutInflater inflater = null;

    public PickUpGameAdapter(Context context, List<PickUpGame> gameList) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.gameList = gameList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.pickup_game_row, null);
        TextView text = (TextView) vi.findViewById(R.id.game_name);
        text.setText(gameList.get(position).getName());
        return vi;
    }

}
