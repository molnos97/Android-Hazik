package com.example.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;

    private final Integer[] imageIDarray;

    private final String[] nameArray;

    private final String[] infoArray;

    private final Double[] buyArray;

    private final Double[] sellArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDArrayParam, Double[] buyArrayParam, Double[] sellArrayParam){

        super(context, R.layout.listview_row, nameArrayParam);
        this.context=context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
        this.buyArray = buyArrayParam;
        this.sellArray = sellArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row2, null, true);

        TextView nameTextField = (TextView)  rowView.findViewById(R.id.textView1);
        TextView currencyTextField = (TextView)  rowView.findViewById(R.id.textView2);
        TextView number1TextField = (TextView)  rowView.findViewById(R.id.textView5);
        TextView number2TextField = (TextView)  rowView.findViewById(R.id.textView6);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView2);

        nameTextField.setText(nameArray[position]);
        currencyTextField.setText(infoArray[position]);
        number1TextField.setText(Double.toString(buyArray[position]));
        number2TextField.setText(Double.toString(sellArray[position]));
        imageView.setImageResource(imageIDarray[position]);
        return rowView;
    }
}