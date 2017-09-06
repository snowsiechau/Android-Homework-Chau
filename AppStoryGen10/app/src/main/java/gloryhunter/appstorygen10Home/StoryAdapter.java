package gloryhunter.appstorygen10Home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by SNOW on 9/5/2017.
 */

public class StoryAdapter extends ArrayAdapter<StoryModel>{
    private static final String TAG = "decodeString";
    private Context context;
    private int resource;
    private List<StoryModel> storyModelList;

    public StoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<StoryModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        storyModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        StoryModel storyModel = storyModelList.get(position);

        View vBookmark = convertView.findViewById(R.id.v_bookmark);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvAuthor = convertView.findViewById(R.id.tv_author);
        ImageView imageView = convertView.findViewById(R.id.iv_image);

        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());

        String base64String = storyModel.getImage();
        String base64Image = base64String.split(",")[1];
        byte[] decodeString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodeByte = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);
        imageView.setImageBitmap(decodeByte);

        return convertView;
    }
}
