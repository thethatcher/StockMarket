package dev.thethatcher;

import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class BoxSeparator extends JSeparator {
	
	BoxSeparator(Integer orientation){
		super(orientation);
		Dimension size;
		if(orientation == JSeparator.VERTICAL) {
			size = new Dimension(1,Integer.MAX_VALUE);
		} else if(orientation == JSeparator.HORIZONTAL) {
			size = new Dimension(Integer.MAX_VALUE,1);
		} else {
			size = new Dimension (1,1);
		}
		this.setMaximumSize(size);
	}
	
	BoxSeparator(int orientation, int maxLength){
		this(orientation);
		Dimension size = this.getSize();
		if(orientation == SwingConstants.VERTICAL) {
			size.height = maxLength;
		} else if(orientation == SwingConstants.HORIZONTAL) {
			size.width = maxLength;
		} 
		this.setMaximumSize(size);
	}
}
