from transformers import GPT2LMHeadModel, GPT2Tokenizer

import sys

def generator(logs):
    cleaned_string = logs.strip("[]")
    log_entries = cleaned_string.split(",")
    logs_text = " ".join(log_entries)
    
    # Load GPT-2 model and tokenizer
    model = GPT2LMHeadModel.from_pretrained("gpt2")  # You can also use "distilgpt2" for an even smaller model
    tokenizer = GPT2Tokenizer.from_pretrained("gpt2")

    # Encode some input text
    input_text = (
        "You are a wise president of a big country, known for your diplomatic abilities. "
        "Transform the following log of events into an engaging, refined narrative: \n\n"
        f"{logs_text} \n\n"
        "Now, tell the story:"
    )

    inputs = tokenizer(input_text, return_tensors="pt")

    # Generate text
    output = model.generate(
        inputs['input_ids'],
        max_length=230, 
        temperature=0.9,  # Higher temperature = more creativity
        top_k=30,  # Limits repetitive words
        top_p=0.9,  # Prevents from selecting the most unlikely words
        do_sample=True,  # Enables sampling (for variation)
        repetition_penalty=1.2,  # Helps avoid excessive repetition
        pad_token_id=tokenizer.eos_token_id
    )

    # Decode the output and print
    generated_text = tokenizer.decode(output[0], skip_special_tokens=True)

    # Strip everything before "Now, tell the story:". I tried in many ways, but the limitations of GPT-2 are too strong
    if "Now, tell the story:" in generated_text:
        generated_text = generated_text.split("Now, tell the story:")[1].strip()

    generated_text = generated_text.replace("\n", " ") # Remove newlines to avoid problems with the Jason beliefs
    generated_text = generated_text.replace("\"", "\'") # Remove symbols to avoid problems with the Jason beliefs

    print(generated_text)

    return "[Story end]"

if __name__ == "__main__":
    logs = sys.argv[1]

    story = generator(logs)
    print(story)