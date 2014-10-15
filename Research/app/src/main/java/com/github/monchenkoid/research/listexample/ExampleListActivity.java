package com.github.monchenkoid.research.listexample;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListAdapter;

import com.github.monchenkoid.research.R;

public class ExampleListActivity extends ListActivity {
	private List<Person> mPeople;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initPeopleList();
		
		// the second parameter in this constructor is useless.
		//ListAdapter adapter = new BadPeopleAdapter(this, 0, mPeople);
		
		// although this alternate constructor is better, it still overrides
		// ArrayAdapter, which is misleading.
		//ListAdapter adapter = new BadPeopleAdapter(this, mPeople);
		
		// this final version extends BaseAdapter and makes the most
		// sense semantically. 
		ListAdapter adapter = new GoodPeopleAdapter(this, mPeople);
		
		setListAdapter(adapter);
	}

	private void initPeopleList() {
		mPeople = new ArrayList<Person>();
		addPersonWith("afsdfmsldfmsldnfsldfnsdknfsldkfsd", "123", R.drawable.bruce);
		addPersonWith("ldfsdl;fmsdl", "445", R.drawable.mumbo);
		addPersonWith("sdfsdfsdfcxcvwertjfjfjfjfjgjfjfg", "75", R.drawable.gruntilda);
		addPersonWith("vffdjdabvbvavjsdjv", "345", R.drawable.zero);
	}

	private void addPersonWith(String name, String latestMessage, int avatarRes) {
		Bitmap avatar = BitmapFactory.decodeResource(getResources(), avatarRes);
		Person person = new Person(name);
		person.setLatestMessage(latestMessage);
		person.setAvatar(avatar);
		mPeople.add(person);
	}
}
