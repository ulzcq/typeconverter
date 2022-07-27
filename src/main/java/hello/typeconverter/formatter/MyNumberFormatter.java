package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/** Number: Integer, Long, Float, Double 등의 부모 클래스
 * Locale 정보를 활용해서 나라별로 다른 숫자 포맷을 만들어 준다.
 */
@Slf4j
public class MyNumberFormatter implements Formatter<Number>  { //String은 기본으로 변환되므로 다른 거<>

    /** 문자를 객체로 변경 */
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}", text, locale);
        //"1,000" -> 1000
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
    }

    /** 객체를 문자로 변경*/
    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
