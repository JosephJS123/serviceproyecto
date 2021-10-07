package com.almacen.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.api.repositorio.AlmacenServicio;
import com.almacen.api.repositorio.InventarioServicio;
import com.almacen.api.repositorio.KardexServicio;
import com.almacen.api.repositorio.MovimientoServicio;
import com.almacen.api.repositorio.PedidointernoServicio;
import com.almacen.api.entidad.Inventario;
import com.almacen.api.entidad.Almacen;
import com.almacen.api.entidad.Kardex;
import com.almacen.api.entidad.Movimiento;
import com.almacen.api.entidad.Pedidointerno;

@RestController
@RequestMapping("/almacen")
public class AlmacenREST {

	@Autowired
	private AlmacenServicio almacenServicio;
	
	@Autowired
	private InventarioServicio inventarioServicio;
	
	@Autowired
	private KardexServicio kardexServicio;
	
	@Autowired
	private MovimientoServicio movimientoServicio;
	
	@Autowired
	private PedidointernoServicio pedidointernoServicio;
	
	//-------------------------------ALMACEN-----------------------------
	//LISTAR ALMACEN
	@RequestMapping(value = "listaralmacen",method = RequestMethod.GET)
	public ResponseEntity<List<Almacen>> getAlmacen(){
		
		List<Almacen> al = almacenServicio.findAll();
		return ResponseEntity.ok(al);
	}
	//LISTAR POR ID
	@RequestMapping(value = "listaralmacen/{almacenId}",method = RequestMethod.GET)
	public ResponseEntity<Almacen> getAlmacenById(@PathVariable("almacenId") Long alId){
		
		Optional<Almacen> optionalAlmacen = almacenServicio.findById(alId);
		
		if(optionalAlmacen.isPresent()) {
			return ResponseEntity.ok(optionalAlmacen.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	//GUARDAR ALMACEN
	@PostMapping
	@RequestMapping(value = "guardaralmacen",method = RequestMethod.POST)
	public ResponseEntity<Almacen> crearAlmacen(@RequestBody Almacen al){
	    Almacen nuevoAlmacen = almacenServicio.save(al);
		return ResponseEntity.ok(nuevoAlmacen);
	}
	//ELIMINAR ALMACEN
	@PostMapping
	@RequestMapping(value = "eliminaralmacen/{almacenId}",method = RequestMethod.DELETE)
	public ResponseEntity<Almacen> crearAlmacen(@PathVariable("almacenId") Long alId){
		almacenServicio.deleteById(alId);
		return ResponseEntity.ok(null);
	}
	
	// ACTUALIZAR ALMACEN
			@PutMapping
			@RequestMapping(value = "editAlmacen",method = RequestMethod.PUT)
			public ResponseEntity<Almacen> actualizarAlmacen(@RequestBody Almacen almacen){
				
				Optional<Almacen> optionalAlmacen = almacenServicio.findById(almacen.getIdalmacen());
				
				if(optionalAlmacen.isPresent()) {
					Almacen actualizarAlmacen = optionalAlmacen.get();
					actualizarAlmacen.setNomalmacen(almacen.getNomalmacen());
					actualizarAlmacen.setDescripcion(almacen.getDescripcion());
					
					almacenServicio.save(actualizarAlmacen);
					return ResponseEntity.ok(actualizarAlmacen);
				}else {
					return ResponseEntity.noContent().build();
				}
			}
	
	//-------------------------------INVENTARIO-----------------------------------------------------
	//LISTAR INVENTARIO
	@RequestMapping(value = "listarinventario",method = RequestMethod.GET)
	public ResponseEntity<List<Inventario>> getInventario(){
				
		List<Inventario> in = inventarioServicio.findAll();
		return ResponseEntity.ok(in);
	}
	//LISTAR POR ID
	@RequestMapping(value = "listarinventario/{inventarioId}",method = RequestMethod.GET)
	public ResponseEntity<Inventario> getInventarioById(@PathVariable("inventarioId") Long inId){
				
		Optional<Inventario> optionalInventario = inventarioServicio.findById(inId);
				
		if(optionalInventario.isPresent()) {
					return ResponseEntity.ok(optionalInventario.get());
		}else {
					return ResponseEntity.noContent().build();
		}
	}
	//GUARDAR INVENTARIO
	@PostMapping
	@RequestMapping(value = "guardarinventario",method = RequestMethod.POST)
	public ResponseEntity<Inventario> crearInventario(@RequestBody Inventario in){
		Inventario nuevoInventario = inventarioServicio.save(in);
		return ResponseEntity.ok(nuevoInventario);
	}
	//ELIMINAR EMPLEADO
	@PostMapping
	@RequestMapping(value = "eliminarinventario/{inventarioId}",method = RequestMethod.DELETE)
		public ResponseEntity<Inventario> crearInventario(@PathVariable("inventarioId") Long inId){
		inventarioServicio.deleteById(inId);
		return ResponseEntity.ok(null);
	}
	//---------------------------------KARDEX--------------------------------------------------
	//LISTAR KARDEX
	@RequestMapping(value = "listarkardex",method = RequestMethod.GET)
	public ResponseEntity<List<Kardex>> getKardex(){
					
		List<Kardex> ka = kardexServicio.findAll();
		return ResponseEntity.ok(ka);
	}
	//LISTAR POR ID
	@RequestMapping(value = "listarkardex/{kardexId}",method = RequestMethod.GET)
	public ResponseEntity<Kardex> getKardexById(@PathVariable("kardexId") Long kaId){
					
		Optional<Kardex> optionalKardex = kardexServicio.findById(kaId);
					
		if(optionalKardex.isPresent()) {
						return ResponseEntity.ok(optionalKardex.get());
		}else {
						return ResponseEntity.noContent().build();
		}
	}
	//GUARDAR KARDEX
	@PostMapping
	@RequestMapping(value = "guardarkardex",method = RequestMethod.POST)
	public ResponseEntity<Kardex> crearKardex(@RequestBody Kardex ka){
		Kardex nuevoKardex = kardexServicio.save(ka);
		return ResponseEntity.ok(nuevoKardex);
	}
	//ELIMINAR KARDEX
	@PostMapping
	@RequestMapping(value = "eliminarkardex/{kardexId}",method = RequestMethod.DELETE)
		public ResponseEntity<Kardex> crearKardex(@PathVariable("kardexId") Long kaId){
		inventarioServicio.deleteById(kaId);
		return ResponseEntity.ok(null);
	}
	//-----------------------------------MOVIMIENTO-------------------------------------------
	//LISTAR MOVIMIENTO
	@RequestMapping(value = "listarmovimiento",method = RequestMethod.GET)
	public ResponseEntity<List<Movimiento>> getMovimiento(){
						
		List<Movimiento> mo = movimientoServicio.findAll();
		return ResponseEntity.ok(mo);
	}
	//LISTAR POR ID
	@RequestMapping(value = "listarmovimiento/{movimientoId}",method = RequestMethod.GET)
	public ResponseEntity<Movimiento> getMovimientoById(@PathVariable("movimientoId") Long moId){
						
		Optional<Movimiento> optionalMovimiento = movimientoServicio.findById(moId);
						
		if(optionalMovimiento.isPresent()) {
							return ResponseEntity.ok(optionalMovimiento.get());
		}else {
							return ResponseEntity.noContent().build();
		}
	}
	//GUARDAR MOVIMIENTO
	@PostMapping
	@RequestMapping(value = "guardarmovimiento",method = RequestMethod.POST)
	public ResponseEntity<Movimiento> crearMovimiento(@RequestBody Movimiento mo){
		Movimiento nuevoMovimiento = movimientoServicio.save(mo);
		return ResponseEntity.ok(nuevoMovimiento);
	}
	//ELIMINAR MOVIMIENTO
	@PostMapping
	@RequestMapping(value = "eliminarmovimiento/{movimientoId}",method = RequestMethod.DELETE)
		public ResponseEntity<Movimiento> crearMovimiento(@PathVariable("movimientoId") Long moId){
		movimientoServicio.deleteById(moId);
		return ResponseEntity.ok(null);
	}
	//-----------------------------------PEDIDOINTERNO-----------------------------------------
	//LISTAR PEDIDOINTERNO
	@RequestMapping(value = "listarpedido",method = RequestMethod.GET)
	public ResponseEntity<List<Pedidointerno>> getPedidointerno(){
							
		List<Pedidointerno> pi = pedidointernoServicio.findAll();
		return ResponseEntity.ok(pi);
	}
	//LISTAR POR ID
	@RequestMapping(value = "listarpedido/{pedidointernoId}",method = RequestMethod.GET)
	public ResponseEntity<Pedidointerno> getPedidointernoById(@PathVariable("pedidointernoId") Long piId){
							
		Optional<Pedidointerno> optionalPedidointerno = pedidointernoServicio.findById(piId);
							
		if(optionalPedidointerno.isPresent()) {
								return ResponseEntity.ok(optionalPedidointerno.get());
			}else {
								return ResponseEntity.noContent().build();
		}
	}
	//GUARDAR PEDIDOINTERNO
	@PostMapping
	@RequestMapping(value = "guardarpedido",method = RequestMethod.POST)
	public ResponseEntity<Pedidointerno> crearPedidointerno(@RequestBody Pedidointerno pi){
		Pedidointerno nuevoPedidointerno = pedidointernoServicio.save(pi);
		return ResponseEntity.ok(nuevoPedidointerno);
	}
	//ELIMINAR PEDIDOINTERNO
	@PostMapping
	@RequestMapping(value = "eliminarpedido/{pedidointernoId}",method = RequestMethod.DELETE)
		public ResponseEntity<Pedidointerno> crearPedidointerno(@PathVariable("pedidointernoId") Long piId){
		pedidointernoServicio.deleteById(piId);
		return ResponseEntity.ok(null);
	}
}
