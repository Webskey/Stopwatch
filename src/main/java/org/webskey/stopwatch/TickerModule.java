package org.webskey.stopwatch;

import javax.swing.JLabel;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class TickerModule extends AbstractModule {

	private JLabel timeLabel;
	private JLabel totalDayTime;

	public TickerModule(JLabel timeLabel, JLabel totalDayTime) {
		this.timeLabel = timeLabel;
		this.totalDayTime = totalDayTime;
	}
	
	@Override
	protected void configure() {
		bind(JLabel.class).annotatedWith(Names.named("timeLabel")).toInstance(timeLabel);
		bind(JLabel.class).annotatedWith(Names.named("totalDayTime")).toInstance(totalDayTime);
	} 
}
