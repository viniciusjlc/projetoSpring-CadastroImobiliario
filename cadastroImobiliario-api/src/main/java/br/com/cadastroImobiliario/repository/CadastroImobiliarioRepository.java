package br.com.cadastroImobiliario.repository;

import br.com.cadastroImobiliario.domain.CadastroImobiliario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CadastroImobiliarioRepository extends JpaRepository<CadastroImobiliario, Long> {
    Optional<List<CadastroImobiliario>> findByUsuarioId(Long id);
}
