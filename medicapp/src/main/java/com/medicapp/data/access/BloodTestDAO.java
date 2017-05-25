package com.medicapp.data.access;

import com.medicapp.data.model.BloodTest;

public interface BloodTestDAO {
	BloodTest getTest(int idcons);
	void addTest(int idcons , String hgb , String paletets , String vsh , String tsh , String mg , String fe);
}
