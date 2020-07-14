package com.pais.daoImpl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.pais.bean.AuthUsuario;
import com.pais.bean.Menu;
import com.pais.dao.AccesoDao;
import com.pais.util.Constantes;
import com.pais.util.LoggerCustom;

@Repository
public class AccesoDaoImpl implements AccesoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	@SuppressWarnings("unchecked")
	@Override
	public AuthUsuario autenticacionUsuario(String username) {

		AuthUsuario usuario = null;

		try {
			jdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource());
			jdbcCall.withSchemaName("dbo").withProcedureName("autenticacionUsuario")
					.declareParameters(new SqlParameter("USERNAME", Types.VARCHAR));

			MapSqlParameterSource parametros = new MapSqlParameterSource();
			parametros.addValue("USERNAME", username);

			Map<String, Object> results = jdbcCall.execute(parametros);
			List<Map<String, Object>> rs = (List<Map<String, Object>>) results.get(Constantes.RETURN_RESULT_SET_PREFIX);

			if (rs.size() > 0) {
				for (Map<String, Object> map : rs) {

					usuario = new AuthUsuario();

					usuario.setIdCodigo((long) map.get("ID_CODIGO"));
					usuario.setCidUsuario((String) map.get("CID_USUARIO").toString().trim());
					usuario.setCidClave((String) map.get("CID_CLAVE").toString().trim());
					usuario.setCidNombre((String) map.get("CID_NOMBRE").toString().trim());
					usuario.setPuesto((String) map.get("PUESTO").toString().trim());

				}
			}

		} catch (Exception e) {
			LoggerCustom.errorApp("", "", e);
		}

		return usuario;
	}

	@Override
	public List<Menu> menu(int idUsuario) {

		List<Menu> listaMenu = new ArrayList<>();
		Menu menu = null;

		try {
			jdbcCall = new SimpleJdbcCall(jdbcTemplate.getDataSource());
			jdbcCall.withSchemaName("dbo").withProcedureName("coleccionMenu")
					.declareParameters(new SqlParameter("ID_USUARIO", Types.INTEGER));

			MapSqlParameterSource parametros = new MapSqlParameterSource();
			parametros.addValue("ID_USUARIO", idUsuario);

			Map<String, Object> results = jdbcCall.execute(parametros);
			List<Map<String, Object>> rs = (List<Map<String, Object>>) results.get(Constantes.RETURN_RESULT_SET_PREFIX);

			if (rs.size() > 0) {
				for (Map<String, Object> map : rs) {

					menu = new Menu();

					menu.setIdCodigo((int) map.get("ID_CODIGO"));
					menu.setFidMenu((int) map.get("FID_MENU"));
					menu.setCidCodigo((String) map.get("CID_CODIGO").toString().trim());
					menu.setCidNombre((String) map.get("CID_NOMBRE").toString().trim());
					menu.setCidUrl((String) map.get("CID_URL").toString().trim());
					menu.setCidIcono((String) map.get("CID_ICONO").toString().trim());

					listaMenu.add(menu);

				}
			}

		} catch (Exception e) {
			LoggerCustom.errorApp("", "", e);
		}

		return listaMenu;
	}

}
