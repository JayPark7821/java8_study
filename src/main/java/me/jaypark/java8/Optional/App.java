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

		Optional<OnlineClass> optionalSpring = springClasses.stream()
			.filter(oc -> oc.getTitle().startsWith("spring"))
			.findFirst();

		boolean present = optionalSpring.isPresent();
		System.out.println("present = " + present);

		Optional<OnlineClass> optionalJay = springClasses.stream()
			.filter(oc -> oc.getTitle().startsWith("jay"))
			.findFirst();

		boolean present1 = optionalJay.isPresent();
		System.out.println("present1 = " + present1);


		//  public void ifPresent(Consumer<? super T> action) {
		//         if (value != null) {
		//             action.accept(value);
		//         }
		//     }
		optionalSpring.ifPresent(oc -> System.out.println(oc.getTitle()));
		
		
		OnlineClass onlineClass = optionalSpring.orElse(createNewClass());
		System.out.println("onlineClass.getTitle() = " + onlineClass.getTitle());

		OnlineClass onlineClass1 = optionalJay.orElse(createNewClass());
		System.out.println("onlineClass1.getTitle() = " + onlineClass1.getTitle());



		OnlineClass onlineClassOrElseGet = optionalSpring.orElseGet(App::createNewClass);
		System.out.println("onlineClass.getTitle() = " + onlineClassOrElseGet.getTitle());

		OnlineClass onlineClass1OrElseGet = optionalJay.orElseGet(() ->createNewClass());
		System.out.println("onlineClass1.getTitle() = " + onlineClass1OrElseGet.getTitle());




		OnlineClass onlineClassOrElseThrow = optionalSpring.orElseThrow(() -> {
			return new IllegalArgumentException();
		});
		System.out.println("onlineClass.getTitle() = " + onlineClassOrElseThrow.getTitle());

		OnlineClass onlineClass1OrElseThrow = optionalJay.orElseThrow(IllegalArgumentException::new);
		System.out.println("onlineClass1.getTitle() = " + onlineClass1OrElseThrow.getTitle());

		Optional<OnlineClass> onlineClass2 = optionalSpring.filter(oc -> !oc.isClosed());
		System.out.println("onlineClass2 = " + onlineClass2.isEmpty());

		Optional<OnlineClass> onlineClass3 = optionalJay.filter(oc -> !oc.isClosed());
		System.out.println("onlineClass3 = " + onlineClass3);



		Optional<Progress> progress1 = optionalSpring.flatMap(OnlineClass::getProgress);


		Optional<Optional<Progress>> progress2 = optionalSpring.map(OnlineClass::getProgress);
		Optional<Progress> progress3 = progress2.orElseThrow();


	}

	private static OnlineClass createNewClass() {
		System.out.println("creating new online class");
		return new OnlineClass(10,"New Class", false);
	}
}
