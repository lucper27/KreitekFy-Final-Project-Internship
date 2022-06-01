import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageconverterService {

  constructor() { }

  includeImageInItem($event: any): Promise<string[] | void>{
    const inputFile = $event.target as HTMLInputElement;
    const file: File | null = inputFile.files?.item(0) ?? null;

    const res = this.readFileAsString(file!).then((result) => {
        const response: string[] = [];
        const imageType: string = this.getImageType(result);
        const imageBase64: string = this.getImageBase64(result);
        response.push(imageType);
        response.push(imageBase64);
        return response;
      },
      (error) =>{
        console.log("No se pudo cargar la imagen");
      });
    return res;
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
