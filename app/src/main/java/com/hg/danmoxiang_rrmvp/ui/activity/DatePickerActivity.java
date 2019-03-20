package com.hg.danmoxiang_rrmvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.hg.danmoxiang_rrmvp.R;
import com.hg.danmoxiang_rrmvp.app.contants.SysConstants;
import com.hg.danmoxiang_rrmvp.ui.base.BaseActivity;
import com.hg.danmoxiang_rrmvp.ui.widget.Calendar.CalendarList;
import com.wuxiaolong.androidutils.library.LogUtil;

import butterknife.BindView;

public class DatePickerActivity extends BaseActivity {

    @BindView(R.id.cldatepicker)
    CalendarList calendarList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_picker);
        calendarList.setOnDateSelected(new CalendarList.OnDateSelected() {
            @Override
            public void selected(String startDate, String endDate) {
                LogUtil.d("startDate:" + startDate +",endDate:" + endDate);
                Intent intent = new Intent();
                intent.putExtra("resultStr",startDate + "至" + endDate);
                setResult(SysConstants.REQUEST_CODE_DATEPICK_CODE,intent);
                finish();
            }
        });
    }


}
