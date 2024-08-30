package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 클래스 레벨이 붙는거
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
