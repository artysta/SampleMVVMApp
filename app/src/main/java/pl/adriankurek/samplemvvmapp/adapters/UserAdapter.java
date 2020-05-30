package pl.adriankurek.samplemvvmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pl.adriankurek.samplemvvmapp.R;
import pl.adriankurek.samplemvvmapp.models.User;

public class UserAdapter extends BaseAdapter {
    private List<User> users;
    private Context ctx;
    private LayoutInflater inflater;

    public UserAdapter(Context ctx, List<User> users){
        this.ctx = ctx;
        this.users = users;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return users.size();
    }

    public Object getItem(int position){
        return users.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if (convertView == null){
            convertView = inflater.inflate(R.layout.user_simple_list,null);
            viewHolder = new ViewHolder();
            viewHolder.txtName = convertView.findViewById(R.id.txt_name);
            viewHolder.txtBirthYear = convertView.findViewById(R.id.txt_birth_year);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User currentUser = users.get(position);

        viewHolder.txtName.setText(currentUser.getName());
        viewHolder.txtBirthYear.setText(String.valueOf(currentUser.getBirthYear()));

        return convertView;
    }

    private static class ViewHolder{
        TextView txtName;
        TextView txtBirthYear;
    }
}