package t5sis.slimming;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class contener_view extends BaseAdapter {

    private int icons[];
    private String leters[];
    private Context context;
    private LayoutInflater layoutInflater;

    public  contener_view (Context context,int icons[],String leters[]){
        this.context=context;
        this.leters=leters;
        this.icons=icons;
    }

    @Override
    public int getCount() {
        return leters.length;
    }

    @Override
    public Object getItem(int position) {
        return leters[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View gridview =convertView;

        if(convertView==null){
            layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridview=layoutInflater.inflate(R.layout.contener,null);
        }

        ImageView icone = gridview.findViewById(R.id.icons);
        TextView letter = gridview.findViewById(R.id.letters);

        icone.setImageResource(icons [position]);
        letter.setText(leters[position]);



        return gridview;
    }
}
