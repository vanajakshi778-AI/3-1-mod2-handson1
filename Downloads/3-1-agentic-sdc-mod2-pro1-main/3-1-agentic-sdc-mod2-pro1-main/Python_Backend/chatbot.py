def generate_response(message):

    text = message.lower()

    if "hello" in text:
        return "Hello! 👋 How can I help you?"

    elif "hi" in text:
        return "Hi! Nice to meet you."

    elif "machine learning" in text:
        return (
            "Machine Learning is a subset of AI "
            "that enables computers to learn "
            "from data."
        )

    elif "artificial intelligence" in text or "ai" in text:
        return (
            "Artificial Intelligence is the "
            "simulation of human intelligence "
            "using machines."
        )

    elif "python" in text:
        return (
            "Python is one of the most popular "
            "languages for AI and Machine Learning."
        )

    elif "bye" in text:
        return "Goodbye! Have a wonderful day."

    else:
        return (
            "I'm still learning. "
            "Can you ask another question?"
        )