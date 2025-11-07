with open("image1.jpg", "rb") as image_file:
    image = image_file.read()

with open("image2.jpg", "wb") as image2_file:
    image2_file.write(image)


