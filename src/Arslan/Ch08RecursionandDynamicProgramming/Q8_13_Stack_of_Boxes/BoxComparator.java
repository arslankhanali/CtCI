package Arslan.Ch08RecursionandDynamicProgramming.Q8_13_Stack_of_Boxes;

import java.util.Comparator;

//public class BoxComparator implements Comparator<Box> {
//	@Override
//	public int compare(Box x, Box y){
//		return y.height - x.height;
//	}
//}


public class BoxComparator implements Comparator<Box>{


	@Override
	public int compare(Box o1, Box o2) {
		return o1.height-o2.height;
	}
}
