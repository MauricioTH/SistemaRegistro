package co.edu.unbosque.batch.notification.email;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import co.edu.unbosque.persistence.model.Usuario;

@Service
public class NotificationEmailItemProcessor
		implements ItemProcessor<Usuario, Usuario> {

	@Override
	public Usuario process(Usuario usuario)throws Exception {
		return usuario;
	}

}
