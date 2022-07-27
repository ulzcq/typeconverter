package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConvertController {

    /** 뷰 템플릿에 컨버터 적용하기 */
    @GetMapping("/converter-view")
    public String  converterView(Model model){
        model.addAttribute("number",10000);
        model.addAttribute("ipPort", new IpPort("127.0.0.1",8080));
        return "converter-view";
    }

    /** 타임리프 컨버전 서비스 적용 확인
     * GET: 객체 -> 문자(form)
     */
    @GetMapping("/convert/edit")
    public String converterForm(Model model){
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        Form form = new Form(ipPort);

        model.addAttribute("form", form);
        return "converter-form";
    }

    /** 타임리프 컨버전 서비스 적용 확인
     * POST: 문자(from) -> 객체
     */
    @PostMapping("/convert/edit")
    public String converterEdit(@ModelAttribute Form form, Model model) {
        IpPort ipPort = form.getIpPort();
        model.addAttribute("ipPort", ipPort);
        return "converter-view";
    }

    @Data
    static class Form {
        private IpPort ipPort;

        public Form(IpPort ipPort) {
            this.ipPort = ipPort;
        }
    }
}
