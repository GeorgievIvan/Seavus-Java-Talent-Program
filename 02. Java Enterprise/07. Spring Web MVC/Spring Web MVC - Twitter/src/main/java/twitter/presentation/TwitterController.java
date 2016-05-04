package twitter.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter.business.Message;
import twitter.service.MessageService;

@Controller
@RequestMapping("/messages")
public class TwitterController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listMessages(Model model) {
		
		final List<Message> messages = messageService.getAllMessages(true);
		final List<MessageDto> messageDtos = new ArrayList<MessageDto>(messages.size());
		
		for(final Message message : messages) {
			
			final MessageDto messageDto = new MessageDto(message);
			
			messageDtos.add(messageDto);
		}
		
		model.addAttribute("newMessage", new MessageDto());
		model.addAttribute("messages", messageDtos);
		
		return "messages";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveMessage(@ModelAttribute("newMessage") MessageDto newMessageDto) {
		
		if(!newMessageDto.getText().isEmpty()) {
			
			messageService.saveMessage(newMessageDto.getText());
		}
		
		return "redirect:/messages";
	}
}