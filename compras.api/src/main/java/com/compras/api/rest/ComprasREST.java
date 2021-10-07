package com.compras.api.rest;

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

import com.compras.api.repositorio.ProveedorRepositorio;
import com.compras.api.repositorio.CompraRepositorio;
import com.compras.api.repositorio.ProductoRepositorio;
import com.compras.api.repositorio.DetallecompraRepositorio;
import com.compras.api.entidad.Detallecompra;
import com.compras.api.entidad.Compra;
import com.compras.api.entidad.Proveedor;
import com.compras.api.entidad.Producto;

@RestController
@RequestMapping("/compras")
public class ComprasREST {

	@Autowired
	private CompraRepositorio compraRepositorio;
	
	@Autowired
	private ProveedorRepositorio proveedorRepositorio;
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	@Autowired
	private DetallecompraRepositorio detallecompraRepositorio;
	
	/* ---------- PRODUCTOS ------------------ */
	
	// LISTAR PRODUCTO
			@RequestMapping(value = "listarProducto",method = RequestMethod.GET)
			public ResponseEntity<List<Producto>> getProducto(){
				
				List<Producto> prod = productoRepositorio.findAll();
				return ResponseEntity.ok(prod);
			}
			
	// LISTAR PRODUCTO POR ID
	@RequestMapping(value = "listarProducto/{productoId}",method = RequestMethod.GET)
	public ResponseEntity<Producto> getProductoById(@PathVariable("productoId") Long productoId){
				
		Optional<Producto> optionalProducto = productoRepositorio.findById(productoId);
				
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		}else {
			return ResponseEntity.noContent().build();
		}

			}
	
	// GUARDAR PRODUCTO
		@PostMapping
		@RequestMapping(value = "saveProducto",method = RequestMethod.POST)
		public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
			Producto nuevoProducto = productoRepositorio.save(producto);
			return ResponseEntity.ok(nuevoProducto);
		}
		
   // ELIMINAR PRODUCTO
		@PostMapping
		@RequestMapping(value = "deleteProducto/{productoId}",method = RequestMethod.DELETE)
		public ResponseEntity<Producto> crearProducto(@PathVariable("productoId") Long productoId){
			productoRepositorio.deleteById(productoId);
			return ResponseEntity.ok(null);
		}
	
	// ACTUALIZAR PRODUCTO
		@PutMapping
		@RequestMapping(value = "editProducto",method = RequestMethod.PUT)
		public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
			
			Optional<Producto> optionalProducto = productoRepositorio.findById(producto.getIdproducto());
			
			if(optionalProducto.isPresent()) {
				Producto actualizarProducto = optionalProducto.get();
				actualizarProducto.setNombre(producto.getNombre());
				actualizarProducto.setStock(producto.getStock());
				actualizarProducto.setPrecio(producto.getPrecio());
				
				productoRepositorio.save(actualizarProducto);
				return ResponseEntity.ok(actualizarProducto);
			}else {
				return ResponseEntity.noContent().build();
			}
		}
		
		/* ---------- DETALLE COMPRA ------------------ */
		
	// LISTAR DETALLE COMPRA
			@RequestMapping(value = "listarDetalle",method = RequestMethod.GET)
			public ResponseEntity<List<Detallecompra>> getDetallecompra(){
						
				List<Detallecompra> det = detallecompraRepositorio.findAll();
				return ResponseEntity.ok(det);
			}
	
	// LISTAR DETALLE COMPRA POR ID
	        @RequestMapping(value = "listarDetalle/{detallecompraId}",method = RequestMethod.GET)
			public ResponseEntity<Detallecompra> getDetallecompraById(@PathVariable("detallecompraId") Long detallecompraId){
						
				Optional<Detallecompra> optionalDetallecompra = detallecompraRepositorio.findById(detallecompraId);
						
				if(optionalDetallecompra.isPresent()) {
					return ResponseEntity.ok(optionalDetallecompra.get());
				}else {
					return ResponseEntity.noContent().build();
				}
			}
	        
	     // GUARDAR DETALLE COMPRA
			@PostMapping
			@RequestMapping(value = "saveDetalle",method = RequestMethod.POST)
			public ResponseEntity<Detallecompra> crearDetallecompra(@RequestBody Detallecompra detallecompra){
				
				double subtotal = detallecompra.getSubtotal();
				int cantidad = detallecompra.getCantidad();
				double precio = detallecompra.getProducto().getPrecio();
				
				subtotal = cantidad * precio;
	
				detallecompra.setSubtotal(subtotal);
				Detallecompra nuevoDetallecompra = detallecompraRepositorio.save(detallecompra);
				return ResponseEntity.ok(nuevoDetallecompra);
			}
	        
	     
			
	// LISTAR COMPRA
		@RequestMapping(value = "listarCompra",method = RequestMethod.GET)
		public ResponseEntity<List<Compra>> getCompra(){
			
			List<Compra> com = compraRepositorio.findAll();
			return ResponseEntity.ok(com);
		}
		
		// LISTAR COMPRA POR ID
        @RequestMapping(value = "listarCompra/{compraId}",method = RequestMethod.GET)
		public ResponseEntity<Compra> getCompraById(@PathVariable("compraId") Long compraId){
					
			Optional<Compra> optionalCompra = compraRepositorio.findById(compraId);
					
			if(optionalCompra.isPresent()) {
				return ResponseEntity.ok(optionalCompra.get());
			}else {
				return ResponseEntity.noContent().build();
			}
		}
        
     // GUARDAR  COMPRA
     			@PostMapping
     			@RequestMapping(value = "saveCompra",method = RequestMethod.POST)
     			public ResponseEntity<Compra> crearCompra(@RequestBody Compra compra){
     				
     				double total = compra.getTotalcompra();
     				//String fecha = compra.getHoraActual();
     				
     				//total = subtotal++;
     				compra.setTotal(total);
     				//compra.setFecha(fecha);
     				Compra nuevoCompra = compraRepositorio.save(compra);
     				return ResponseEntity.ok(nuevoCompra);
     			}
		
	// LISTAR PROVEEDOR
		@RequestMapping(value = "listarProveedor",method = RequestMethod.GET)
		public ResponseEntity<List<Proveedor>> getProveedor(){
					
			List<Proveedor> pv = proveedorRepositorio.findAll();
			return ResponseEntity.ok(pv);
		}
		
		// LISTAR PROVEEDOR POR ID
        @RequestMapping(value = "listarProveedor/{proveedorId}",method = RequestMethod.GET)
		public ResponseEntity<Proveedor> getProveedorById(@PathVariable("proveedorId") Long proveedorId){
					
			Optional<Proveedor> optionalProveedor = proveedorRepositorio.findById(proveedorId);
					
			if(optionalProveedor.isPresent()) {
				return ResponseEntity.ok(optionalProveedor.get());
			}else {
				return ResponseEntity.noContent().build();
			}
		}
}

