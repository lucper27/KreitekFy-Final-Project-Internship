import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageconverterService {

  convertedImage: string = '';
  constructor() { }

  includeImageInItem($event: any): string {
    const inputFile = $event.target as HTMLInputElement;
    const file: File | null = inputFile.files?.item(0) ?? null;

    this.readFileAsString(file!).then((result) => {
        const imageType: string = this.getImageType(result);
        console.log(imageType);
        const imageBase64: string = this.getImageBase64(result);
        console.log(imageBase64);

        this.convertedImage = imageBase64;
      },
      (error) =>{
        console.log("No se pudo cargar la imagen");
      })

    return this.convertedImage;
  }

  private readFileAsString(file: File) {
    return new Promise<string>(function(resolve,reject){
      let reader: FileReader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = function(){
        resolve(this.result as string)
      }
    })
  }

  private getImageType(imageString: string): string {
    const imageStringParts: string[] = imageString.split(",");
    if (imageStringParts.length == 2){
      return imageStringParts[0];
    } else {
      return "";
    }
  }

  private getImageBase64(imageString: string): string {
    const imageStringParts: string[] = imageString.split(",");
    if (imageStringParts.length == 2){
      return imageStringParts[1];
    } else {
      return "";
    }
  }
}
