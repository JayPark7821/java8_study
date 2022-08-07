package me.jaypark.java8.Optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));

		OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
		// Duration studyDuration = spring_boot.getProgress().getStudyDuration();
		// System.out.println(studyDuration); // nullpoint exception

		// 이런식으로 처리 했었다......
		// Progress progress = spring_boot.getProgress();
		// if (progress != null) {
		// 	System.out.println(progress.getStudyDuration());
		// }

		Optional<Progress> progress = spring_boot.getProgress();
		progress.ifPresent(p -> System.out.println(p.getStudyDuration()));


	}
}
