package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	// INJECAO DE DEPENDENCIA COM O MEU CONN POR MEIO DO CONSTRUTOR
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {

	}

	@Override
	public void update(Seller obj) {
	}

	@Override
	public void deleteById(Seller obj) {

	}

	@Override
	public Seller findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

			st.setInt(1, id);
			// CONSULTA SQL, POREM O RS ESTA APONTANDO PARA POSIÇÃO ZERO
			rs = st.executeQuery();
			// CRIEI O IF PARA TESTAR SE VEIO ALGUM RESULTADO E SE NÃO VEIO POIS RS AINDA É
			// = O VAI RETORNAR NULL
			if (rs.next()) {
				Department dep = instantiateDeparment(rs);
				Seller obj = instantiateSeller(rs, dep);
				return obj;
			}
			// VAI RETORNAR NULL NA PRIMEIRA VEZ POIS RS AINDA É = 0
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {

		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instantiateDeparment(ResultSet rs) throws SQLException {
		Department dep = new Department();

		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));

		return dep;
	}

	@Override
	public List<Seller> findAll() {

		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");

			st.setInt(1, department.getId());
			
			rs = st.executeQuery();
		
			List<Seller> list = new ArrayList<Seller>();
			
			Map<Integer, Department> map = new HashMap<>();
			
			
			while (rs.next()) {
				
				//PEGA O DEPARTAMENTO SE NÃO EXISTIR dep FICA NULL. SE EXISTIR O MEU IF VAI DAR FALSO E NÃO VAI INSTANCIAR UM NOVO DEPARTAMENTO
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				//VERIFICA SE O DEPARTAMENTO É NULL, E SE FOR VAI INSTANCIAR O DEPARTAMENTO, ADCIONANDO AO MAP(map.put())
				if(dep == null) {
					dep = instantiateDeparment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller obj = instantiateSeller(rs, dep);
				
				list.add(obj);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
