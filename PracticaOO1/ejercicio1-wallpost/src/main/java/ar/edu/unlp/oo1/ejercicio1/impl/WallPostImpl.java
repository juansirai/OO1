package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {

	/**
	 * Complete con su implementación
	 **/
	private String texto;
	private int likes;
	private boolean destacado;
	

	/*
	* Permite construir una instancia del WallpostImpl.
	* Luego de la invocación, debe tener como texto: “Undefined post”,
	* no debe estar marcado como destacado y la cantidad de “Me gusta” deben ser 0.
	*/

	public WallPostImpl() {
		this.texto = "Undefined post";
		this.likes = 0;
		this.destacado = false;
	}
	
	/*
	* Retorna el texto descriptivo de la publicación
	*/
	public String getText() {
		return this.texto;
	} 

	/*
	* setea el texto descriptivo de la publicación
	*/
	public void setText (String descriptionText) {
		this.texto = descriptionText;
	}

	/*
	* retorna la cantidad de “me gusta”
	*/
	public int getLikes() {
		return this.likes;
	}

	/*
	 * Incrementa la cantidad de likes en uno.
	*/
	public void like() {
		this.likes++;
	}

	/*
	 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada..
	*/
	public void dislike() {
		if(this.getLikes()>0)
			this.likes--;
	}

	/*
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	*/
	public boolean isFeatured() {
		return this.destacado;
	}

	/*
	 * Cambia el post del estado destacado a no destacado y viceversa.
	*/
	public void toggleFeatured() {
		this.destacado = !this.isFeatured();
	}

	
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }


}
